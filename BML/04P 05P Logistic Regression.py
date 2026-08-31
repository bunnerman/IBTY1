import pandas as pd
from sklearn.datasets import load_breast_cancer 
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, precision_score, recall_score, f1_score

db = load_breast_cancer() # load db
X = pd.DataFrame(db.data, columns=db.feature_names) # separate X and y
y = db.target

# 4:1::training:testing
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=1, stratify=y)

# scaling/normalization
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

# create and train KNN classifier
k_initial = 5 # use test value of k initially as 5 (not too extreme)
knn = KNeighborsClassifier(n_neighbors=k_initial)
knn.fit(X_train_scaled, y_train)
y_pred = knn.predict(X_test_scaled) # test via predicting

# see model results
print(f"Accuracy: {accuracy_score(y_test, y_pred):.4f}")
print(f"Precision: {precision_score(y_test, y_pred):.4f}")
print(f"Recall: {recall_score(y_test, y_pred):.4f}")
print(f"F1-Score: {f1_score(y_test, y_pred):.4f}")
print("\nConfusion Matrix:")
print(confusion_matrix(y_test, y_pred))

# experiment with other values of k
print("\n" + "="*50)
print("--- K-Value Comparison ---")
print(f"{'K Value':<10}{'Accuracy':<12}{'Precision':<12}{'Recall':<12}{'F1-Score':<12}")
print("-" * 50)

k_values = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
for k in k_values:
    model = KNeighborsClassifier(n_neighbors=k)
    model.fit(X_train_scaled, y_train)
    preds = model.predict(X_test_scaled)
    
    acc = accuracy_score(y_test, preds)
    prec = precision_score(y_test, preds)
    rec = recall_score(y_test, preds)
    f1 = f1_score(y_test, preds)
    
    print(f"{k:<10}{acc:<12.4f}{prec:<12.4f}{rec:<12.4f}{f1:<12.4f}")
