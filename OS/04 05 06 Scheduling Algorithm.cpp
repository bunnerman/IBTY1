// Code for FCFS, SJF and RR implementation

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <climits>

using std::cout, std::cin, std::string, std::vector, std::swap;

class ScheduleProcesses
{
private:
	int n;
	vector<int> at, bt, ct, tat, wt;
	// vector<string> asdfjkl;
	
	// int sjfHelper()
	// {
	// 	return 0;
	// }
public:
	void acceptProcesses(vector<int> at, vector<int> bt)
	{
		this->n = at.size();
		this->at = at;
		this->bt = bt;
	}

	void rearrangeList()
	{
		int n = at.size();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (at[i] > at[j])
				{
					swap(at[i], at[j]);
					swap(bt[i], bt[j]);
				}
	}

	int fcfs()
	{
		int t = 0;
		n = at.size();
		ct.clear(); tat.clear(); wt.clear();
		ct.resize(n); tat.resize(n); wt.resize(n);
		rearrangeList();

		for (int i = 0; i < n; i++)
		{
			if (at[i] > t) // if idle time
				t = at[i] + bt[i];
			else
				t += bt[i]; 
			
			ct[i] = t;
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
		}

		return t;
	}

	int sjf()
	{
		int t = 0;
        n = at.size();
        ct.clear(); tat.clear(); wt.clear();
        ct.resize(n); tat.resize(n); wt.resize(n);
        rearrangeList();

        vector<bool> compP(n, false);
        int cp = 0; // number of completed processes

        while (cp < n)
        {
            int minI = -1; // minimum index for currently available viable process
            int minBt = INT_MAX;

            for (int i = 0; i < n; i++)
                if (!compP[i] && at[i] <= t && bt[i] < minBt)
                {
                    minBt = bt[i];
                    minI = i;
                }

            if (minI == -1)
            {
                int nextAt = INT_MAX;
                for (int i = 0; i < n; i++)
                    if (!compP[i] && at[i] < nextAt)
                        nextAt = at[i];
                t = nextAt;
                continue;
            }

            t += bt[minI];
            ct[minI] = t;
            compP[minI] = true;
            cp++;
        }

        for (int i = 0; i < n; i++)
        {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        return t;
	}
	
	int rr(int tq)
	{
		int t = 0;
        n = at.size();
        ct.clear(); tat.clear(); wt.clear();
        ct.resize(n); tat.resize(n); wt.resize(n);
        rearrangeList();

		vector<int> rt = bt; // remaining time
        int cmplt = 0;

        if (n > 0) 
			t = at[0];

        while (cmplt < n)
        {
            bool found = false;

            for (int i = 0; i < n; i++)
                if (at[i] <= t && rt[i] > 0)
                {
                    found = true;

                    if (rt[i] > tq)
                    {
                        t += tq;
                        rt[i] -= tq;
                    }
                    else
                    {
                        t += rt[i];
                        rt[i] = 0;
                        ct[i] = t;
                        cmplt++;
                    }
                }

            if (!found)
                t++;
        }

        for (int i = 0; i < n; i++)
        {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

		return t;
	}

	void printTimes(string name)
	{
		cout << "\n--------" << name << "--------\n";

		cout << "\nCompletion Time: ";
		for (int &i : ct)
			cout << i << " ";

		float avgtat = 0, avgwt = 0;
		cout << "\nTurn Around Time: ";
		for (int &i : tat)
		{
			cout << i << " ";
			avgtat += i;
		}
		cout << "\nWaiting Time: ";
		for (int &i : wt)
		{
			cout << i << " ";
			avgwt += i;
		}

		avgtat /= n; avgwt /= n;
		cout << "\nAverage Turn Around Time: " << avgtat << "\n";
		cout << "Average Waiting Time: " << avgwt << "\n";
	}
};

int main()
{
	int ch;
	int n;
	vector<int> at, bt;
	ScheduleProcesses obj;
	cout << "[-1 Quit]\n[0 Accept New Input]\n[1 FCFS]\n[2 SJF]\n[3 RR]\n";

	while (true)
	{
		cout << "\nCHOICE: ";
		cin >> ch;
			switch (ch)
			{
				case -1: // get out
					return 0;
				case 0: // reaccept input
					cout << "Enter number of processes: "; 
					cin >> n;
					at.clear(); bt.clear();
					at.resize(n); bt.resize(n);
					cout << "Enter Arrival Times (" << n << "): ";
					for (int i = 0; i < n; i++)
						cin >> at[i];
					cout << "Enter Burst Times (" << n << "): ";
					for (int i = 0; i < n; i++)
						cin >> bt[i];
				break;
				case 1:
					obj.acceptProcesses(at, bt);
					obj.fcfs();
					obj.printTimes("FCFS");
				break;
				case 2:
					obj.acceptProcesses(at, bt);
					obj.sjf();
					obj.printTimes("SJF");
				break;
				case 3:
					int tq;
					cout << "Enter time quantum: ";
					cin >> tq;
					obj.acceptProcesses(at, bt);
					obj.rr(tq);
					obj.printTimes("RR");
				break;
				default:
					cout << "Invalid Number\n";
			}
	}

	// int n;
	// cout << "Enter number of processes: "; 
	// cin >> n;
	// vector<int> at(n), bt(n);
	// cout << "Enter Arrival Times (" << n << "): ";
	// for (int i = 0; i < n; i++)
	// 	cin >> at[i];

	// cout << "Enter Burst Times (" << n << "): ";
	// for (int i = 0; i < n; i++)
	// 	cin >> bt[i];

	// ScheduleProcesses obj;
	// obj.acceptProcesses(at, bt);
	
	// obj.fcfs();
	// obj.printTimes("First Come First Serve");

	// obj.sjf();
	// obj.printTimes("Shortest Job First (Non Preemptive)");

	// obj.rr(2);
	// obj.printTimes("Round Robin");
}
