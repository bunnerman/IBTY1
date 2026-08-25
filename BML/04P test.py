import numpy as np
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

# 1. Generate sample data (e.g., hours studied vs. pass [1] / fail [0])
X = np.array([[1], [2], [3], [4], [5], [6], [7], [8], [9], [10]])
y = np.array([0, 0, 0, 0, 1, 0, 1, 1, 1, 1])

# 2. Split data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# 3. Create and train the model
model = LogisticRegression()
model.fit(X_train, y_train)

# 4. Make predictions
y_pred = model.predict(X_test)

# 5. Evaluate accuracy and view predicted probabilities
print("Predictions:", y_pred)
print("Accuracy:", accuracy_score(y_test, y_pred))
print("Probabilities (Fail vs Pass):\n", model.predict_proba(X_test))


#---------------
#-----------


import numpy as np
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report

# 1. Load the dataset
iris = load_iris()

# Extract Sepal Length (Column 0) as our single input feature
X = iris.data[:, :1] 

# 2. Define custom threshold condition (sepal length > 5.5 cm)
# Creates binary target: 1 if > 5.5, 0 if <= 5.5
y = (X > 5.5).astype(int).ravel() 

# 3. Split into train and test sets
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# 4. Train Logistic Regression
model = LogisticRegression()
model.fit(X_train, y_train)

# 5. Make predictions and evaluate
y_pred = model.predict(X_test)
print("Accuracy:", accuracy_score(y_test, y_pred))

# Test custom sepal length predictions
sample_lengths = np.array([[4.8], [5.5], [6.2]])
predictions = model.predict(sample_lengths)
probs = model.predict_proba(sample_lengths)[:, 1]

for length, pred, prob in zip(sample_lengths.ravel(), predictions, probs):
    status = "> 5.5 cm" if pred == 1 else "<= 5.5 cm"
    print(f"Sepal Length {length} cm -> Predicted: {status} (Prob: {prob:.2%})")
