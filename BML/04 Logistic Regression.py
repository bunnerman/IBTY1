import numpy as np
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn import datasets
from sklearn.preprocessing import StandardScaler

iri = datasets.load_iris()
X = iri.data
y = iri.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1, stratify=y)

scaler=StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

model = LogisticRegression()
model.fit(X_train_scaled, y_train)

y_pred = model.predict(X_test_scaled)	
v = model.predict_proba(X_test_scaled)

print("Predictions: ", y_pred)
print("Accuracy: ", accuracy_score(y_test, y_pred))
print("Probabilities-\n", v.round(2))
