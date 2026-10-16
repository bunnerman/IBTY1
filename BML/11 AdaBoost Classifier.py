from sklearn.datasets import load_breast_cancer
import pandas as pd
import numpy as np
from sklearn.metrics import classification_report, confusion_matrix, accuracy_score, f1_score
from sklearn.model_selection import train_test_split
from sklearn.ensemble import AdaBoostClassifier
from sklearn.tree import DecisionTreeClassifier

db = load_breast_cancer()
X = pd.DataFrame(db.data, columns=db.feature_names)
y = db.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1, stratify=y)

base_learner = DecisionTreeClassifier(max_depth=1, random_state=1) # stump cuz max depth is 1
model = AdaBoostClassifier(estimator=base_learner, n_estimators=50, random_state=1)

model.fit(X_train, y_train)
y_pred = model.predict(X_test)

# also learning rate is 1.0 because wasn't specified
print("n estimators:", model.n_estimators)
print(confusion_matrix(y_test, y_pred))
print(classification_report(y_test, y_pred))

print(f"Estmtrs   Acccuracy    F1 Score")
for n in (10, 20, 30, 40, 50, 60, 70, 80, 90, 100):
    model2 = AdaBoostClassifier(estimator=base_learner, n_estimators=n, random_state=1)
    model2.fit(X_train, y_train)
    y_pred2 = model2.predict(X_test)
    acc = round(accuracy_score(y_test, y_pred2), 3)
    f1s = round(f1_score(y_test, y_pred2), 3)
    print(f"{n:3d}        {acc}       {f1s}")
