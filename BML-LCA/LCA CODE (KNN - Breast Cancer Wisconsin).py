import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix, classification_report

cols = ['id', 'diag'] + ['c' + str(i) for i in range(3, 33)] 
# other feature columns name irrelevant, too complex naming system in wdbc.name documentation

df = pd.read_csv('wdbc.data', header=None, names=cols)
X = df.drop(columns=['id', 'diag'])
y = df['diag'].map({'M': 1, 'B':0}) # malignant is 1, benign is 0

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1, stratify=y)
sc = StandardScaler() # so features dont have disproportionate influence
X_train_sc = sc.fit_transform(X_train)
X_test_sc = sc.transform(X_test)

for k in range(1, 12, 2):
	knn = KNeighborsClassifier(n_neighbors=k)
	knn.fit(X_train_sc, y_train)
	y_pred = knn.predict(X_test_sc)
	print(f"K: {k} | Accuracy: {accuracy_score(y_test, y_pred)}")

# additional metrics if required
# print(classification_report(y_test, y_pred))
# print(confusion_matrix(y_test, y_pred))
