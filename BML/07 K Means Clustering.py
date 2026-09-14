import pandas as pd
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans

plt.style.use('dark_background')

markSeg = pd.read_csv('markSeg.csv')

X = markSeg[['AnnualIncome', 'SpendingScore']]

k_range = range(2, 5+1)
k_ary = []

for k in k_range:
	model = KMeans(n_clusters= k, init= 'k-means++', random_state= 1, n_init= 10)
	model.fit(X)
	if (k == k_range[0]):
		bestInertia = model.inertia_
	if (model.inertia_ > bestInertia):
		bestInertia = model.inertia_
	k_ary.append(model.inertia_)

plt.plot(k_range, k_ary, marker='.')
plt.title("Elbow Method Step - K Means")
plt.xlabel("K Value")
plt.ylabel("Inertia")
plt.xticks(k_range)
plt.show()


finalK = int(input("Enter Optimal Value of K Observed (Dimishing Returns): "))

model = KMeans(n_clusters= finalK, init= 'k-means++', random_state= 1, n_init= 10)
markSeg['Cluster'] = model.fit_predict(X)

a = markSeg['AnnualIncome']
b = markSeg['SpendingScore']
plt.scatter(a, b, c= markSeg['Cluster'], cmap= 'gist_rainbow')

cents = model.cluster_centers_
plt.scatter(cents[:, 0], cents[:, 1], c=range(finalK), marker='X', cmap='gist_rainbow')


plt.title("Scatter Plot of K-Means Clustering")
plt.xlabel("Annual Income")
plt.ylabel("Spending Score")
plt.show()
