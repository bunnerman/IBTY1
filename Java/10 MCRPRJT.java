import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class McProj extends JFrame
{
    private static final String QUIZ_DIR = "quizzes";
    private File currentFile;
    private ArrayList<Question> quizList = new ArrayList<>();
    private int score = 0, qIndex = 0;
    private boolean isUpdatingDropdown = false;

    private JComboBox<String> quizSelectorBox = new JComboBox<>();
    private JLabel questionLabel = new JLabel();
    private JPanel optionsPanel = new JPanel();
    private JButton submitButton = new JButton("Submit");
    private JTabbedPane tabs = new JTabbedPane();

    public McProj()
    {
        new File(QUIZ_DIR).mkdir();
        setTitle("Quiz Engine");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Current Quiz:"));
        topPanel.add(quizSelectorBox);

        quizSelectorBox.addActionListener(e ->
        {
            if (!isUpdatingDropdown && quizSelectorBox.getSelectedIndex() != -1)
                refreshQuizData();
        });

        JButton newBtn = new JButton("+ New Quiz");
        newBtn.addActionListener(e ->
        {
            String name = JOptionPane.showInputDialog(this, "Quiz Name:");
            if (name != null && !name.trim().isEmpty())
            {
                currentFile = new File(QUIZ_DIR, name.trim() + (name.endsWith(".json") ? "" : ".json"));
                quizList = new ArrayList<>();
                saveJson();
                updateDropdown();
                quizSelectorBox.setSelectedItem(currentFile.getName());
            }
        });
        topPanel.add(newBtn);
        add(topPanel, BorderLayout.NORTH);

        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JPanel quizPanel = new JPanel(new BorderLayout());
        quizPanel.add(questionLabel, BorderLayout.NORTH);
        quizPanel.add(new JScrollPane(optionsPanel), BorderLayout.CENTER);
        quizPanel.add(submitButton, BorderLayout.SOUTH);
        submitButton.addActionListener(e -> processAnswer());

        tabs.addTab("Quiz", quizPanel);
        tabs.addTab("Add Question", createAddPanel());
        add(tabs, BorderLayout.CENTER);

        updateDropdown();
        refreshQuizData();
    }

    private void loadQuestion(int idx)
    {
        optionsPanel.removeAll();
        if (quizList.isEmpty() || idx >= quizList.size())
        {
            questionLabel.setText(quizList.isEmpty() ? "ADD QUESTIONS" : "COMPLETE");
            submitButton.setEnabled(false);
            if (idx >= quizList.size() && !quizList.isEmpty())
                JOptionPane.showMessageDialog(this, "Marks: " + score + "/" + quizList.size());
        }
        else
        {
            submitButton.setEnabled(true);
            Question q = quizList.get(idx);
            questionLabel.setText("Q" + (idx + 1) + ": " + q.qstn);

            if (q instanceof MCQ mcq)
            {
                ButtonGroup bg = new ButtonGroup();
                for (int i = 0; i < mcq.optns.size(); i++)
                {
                    JRadioButton rb = new JRadioButton((i + 1) + ") " + mcq.optns.get(i));
                    rb.setActionCommand(String.valueOf(i + 1));
                    bg.add(rb);
                    optionsPanel.add(rb);
                }
            }
            else if (q instanceof MRQ mrq)
            {
                for (int i = 0; i < mrq.optns.size(); i++)
                {
                    JCheckBox cb = new JCheckBox((i + 1) + ") " + mrq.optns.get(i));
                    cb.setName(String.valueOf(i + 1));
                    optionsPanel.add(cb);
                }
            }
            else
            {
                optionsPanel.add(new JTextField(20));
            }
        }
        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    private void processAnswer()
    {
        if (quizList.isEmpty() || qIndex >= quizList.size())
            return;

        Question q = quizList.get(qIndex);
        String attempt = "";

        if (q instanceof MCQ)
        {
            for (Component c : optionsPanel.getComponents())
                if (c instanceof JRadioButton rb && rb.isSelected())
                    attempt = rb.getActionCommand();
        }
        else if (q instanceof MRQ)
        {
            List<String> sel = new ArrayList<>();
            for (Component c : optionsPanel.getComponents())
                if (c instanceof JCheckBox cb && cb.isSelected())
                    sel.add(cb.getName());
            attempt = String.join(",", sel);
        }
        else
        {
            for (Component c : optionsPanel.getComponents())
                if (c instanceof JTextField tf)
                    attempt = tf.getText();
        }

        if (q.checkAnswer(attempt))
            score++;

        loadQuestion(++qIndex);
    }

    private JPanel createAddPanel()
    {
        JPanel p = new JPanel(new GridLayout(5, 2));
        JComboBox<String> typeBox = new JComboBox<>(new String[]{"MCQ", "MRQ", "TextBased"});
        JTextField qF = new JTextField(), oF = new JTextField(), aF = new JTextField();

        p.add(new JLabel("Type:"));
        p.add(typeBox);
        p.add(new JLabel("Question:"));
        p.add(qF);
        p.add(new JLabel("Options (; separated):"));
        p.add(oF);
        p.add(new JLabel("Answer(s) (, separated):"));
        p.add(aF);

        JButton saveBtn = new JButton("Add");
        saveBtn.addActionListener(e ->
        {
            if (currentFile == null)
            {
                JOptionPane.showMessageDialog(this, "SELECT OR CREATE QUIZ");
                return;
            }

            String type = (String) typeBox.getSelectedItem();
            List<String> opts = List.of(oF.getText().split(";"));

            if ("MCQ".equals(type))
                quizList.add(new MCQ(qF.getText(), opts, Integer.parseInt(aF.getText().trim())));
            else if ("MRQ".equals(type))
            {
                ArrayList<Integer> ans = new ArrayList<>();
                for (String s : aF.getText().split(","))
                    ans.add(Integer.parseInt(s.trim()));
                quizList.add(new MRQ(qF.getText(), opts, ans));
            }
            else
                quizList.add(new TextBased(qF.getText(), aF.getText().trim()));

            saveJson();

            if (quizList.size() == 1 || qIndex >= quizList.size() - 1)
            {
                qIndex = quizList.size() - 1;
                loadQuestion(qIndex);
            }

            qF.setText("");
            oF.setText("");
            aF.setText("");
            tabs.setSelectedIndex(0);
        });
        p.add(saveBtn);
        return p;
    }

    private void updateDropdown()
    {
        isUpdatingDropdown = true;
        quizSelectorBox.removeAllItems();
        File[] files = new File(QUIZ_DIR).listFiles((d, name) -> name.endsWith(".json"));
        if (files != null)
            for (File f : files)
                quizSelectorBox.addItem(f.getName());
        isUpdatingDropdown = false;
    }

    private void refreshQuizData()
    {
        String selected = (String) quizSelectorBox.getSelectedItem();
        if (selected == null)
        {
            quizList.clear();
            questionLabel.setText("ADD QUIZ FIRST");
            submitButton.setEnabled(false);
            optionsPanel.removeAll();
            optionsPanel.revalidate();
            optionsPanel.repaint();
            return;
        }
        currentFile = new File(QUIZ_DIR, selected);
        loadJson();
        qIndex = score = 0;
        loadQuestion(0);
    }

    private void saveJson()
    {
        if (currentFile == null)
            return;

        try (PrintWriter pw = new PrintWriter(new FileWriter(currentFile)))
        {
            pw.println("[");
            for (int i = 0; i < quizList.size(); i++)
            {
                Question q = quizList.get(i);
                pw.println("  {");
                pw.println("    \"type\": \"" + q.getClass().getSimpleName() + "\",");
                pw.println("    \"qstn\": \"" + q.qstn + "\",");

                if (q instanceof MCQ mcq)
                {
                    pw.println("    \"optns\": [\"" + String.join("\", \"", mcq.optns) + "\"],");
                    pw.println("    \"ans\": " + mcq.correctAnswer);
                }
                else if (q instanceof MRQ mrq)
                {
                    pw.println("    \"optns\": [\"" + String.join("\", \"", mrq.optns) + "\"],");
                    pw.println("    \"ans\": " + mrq.correctAnswers);
                }
                else if (q instanceof TextBased tb)
                {
                    pw.println("    \"ans\": \"" + tb.answer + "\"");
                }

                pw.println("  }" + (i < quizList.size() - 1 ? "," : ""));
            }
            pw.println("]");
        }
        catch (Exception ignored)
        {
        }
    }

    private void loadJson()
    {
        quizList = new ArrayList<>();
        if (currentFile == null || !currentFile.exists())
            return;

        try
        {
            String content = new String(Files.readAllBytes(currentFile.toPath()));
            Matcher m = Pattern.compile("\\{[^\\}]+\\}").matcher(content);
            while (m.find())
            {
                String obj = m.group();
                String type = parseVal(obj, "type");
                String qstn = parseVal(obj, "qstn");

                if ("MCQ".equals(type))
                {
                    List<String> opts = parseList(obj, "optns");
                    int ans = Integer.parseInt(parseVal(obj, "ans"));
                    quizList.add(new MCQ(qstn, opts, ans));
                }
                else if ("MRQ".equals(type))
                {
                    List<String> opts = parseList(obj, "optns");
                    ArrayList<Integer> ans = new ArrayList<>();
                    for (String s : parseVal(obj, "ans").replace("[", "").replace("]", "").split(","))
                        if (!s.trim().isEmpty())
                            ans.add(Integer.parseInt(s.trim()));
                    quizList.add(new MRQ(qstn, opts, ans));
                }
                else if ("TextBased".equals(type))
                {
                    quizList.add(new TextBased(qstn, parseVal(obj, "ans")));
                }
            }
        }
        catch (Exception ignored)
        {
        }
    }

    private String parseVal(String line, String key)
    {
        String k = "\"" + key + "\":";
        int start = line.indexOf(k);
        if (start == -1)
            return "";
        start += k.length();

        while (start < line.length() && Character.isWhitespace(line.charAt(start)))
            start++;

        if (start >= line.length())
            return "";

        char first = line.charAt(start);
        if (first == '"')
        {
            int end = line.indexOf('"', start + 1);
            return end == -1 ? "" : line.substring(start + 1, end);
        }
        else if (first == '[')
        {
            int end = line.indexOf(']', start);
            return (end == -1) ? "" : line.substring(start, end + 1);
        }
        else
        {
            int end = line.indexOf(',', start);
            if (end == -1)
                end = line.indexOf('}', start);
            if (end == -1)
                end = line.length();
            return line.substring(start, end).trim();
        }
    }

    private List<String> parseList(String line, String key)
    {
        List<String> res = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"").matcher(parseVal(line, key));
        while (m.find())
            res.add(m.group(1));
        return res;
    }

    // EXECUTION POINT
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new McProj().setVisible(true));
    }
}

// Question Inheritance Classes, Core of Project
abstract class Question
{
    String qstn;

    public Question(String q)
    {
        this.qstn = q;
    }

    abstract public boolean checkAnswer(String attempt);
}

class MCQ extends Question
{
    List<String> optns;
    int correctAnswer;

    public MCQ(String q, List<String> o, int c)
    {
        super(q);
        this.optns = o;
        this.correctAnswer = c;
    }

    public boolean checkAnswer(String a)
    {
        try
        {
            if (!a.isEmpty() && Integer.parseInt(a.trim()) == correctAnswer)
                return true;
            else
                return false;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}

class MRQ extends Question
{
    List<String> optns;
    ArrayList<Integer> correctAnswers;

    public MRQ(String q, List<String> o, ArrayList<Integer> c)
    {
        super(q);
        this.optns = o;
        this.correctAnswers = c;
    }

    public boolean checkAnswer(String a)
    {
        if (a.isEmpty())
            return false;

        try
        {
            ArrayList<Integer> att = new ArrayList<>();
            for (String i : a.split(","))
                att.add(Integer.parseInt(i.trim()));
            return att.equals(correctAnswers);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}

class TextBased extends Question
{
    String answer;

    public TextBased(String q, String c)
    {
        super(q);
        this.answer = c;
    }

    public boolean checkAnswer(String a)
    {
        return a.trim().equalsIgnoreCase(answer);
    }
}
