from sklearn.datasets import load_breast_cancer
import pandas as pd
import numpy as np
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier

db = load_breast_cancer()
X = pd.DataFrame(db.data, columns=db.feature_names)
y = db.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1, stratify=y)

model = RandomForestClassifier(n_estimators=100, random_state=1)
model.fit(X_train, y_train)

y_pred = model.predict(X_test)

print(classification_report(y_test, y_pred))
print(confusion_matrix(y_test, y_pred))

topI = np.argsort(model.feature_importances_)[::-1][:5] # reverse and pick top 5
for i in topI:
    print(str(X.columns[i]) + " : " + str(model.feature_importances_[i]))
