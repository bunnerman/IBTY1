import pandas as pd
import numpy as np
from sklearn.datasets import load_iris
from sklearn.decomposition import PCA
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt

iri = load_iris()
X = pd.DataFrame(iri.data, columns=iri.feature_names)
y = iri.target

sc = StandardScaler()
X_scaled = sc.fit_transform(X)

pca_var = PCA(n_components=2)

X_pca = pca_var.fit_transform(X_scaled)

vr = pca_var.explained_variance_ratio_
print("PC1 Variance: " + str(vr[0]))
print("PC2 Variance: " + str(vr[1]))
print("Total Variance: " + str(vr[0] + vr[1]))

reduced_df = pd.DataFrame(data=X_pca, columns=["PC1", "PC2"])
reduced_df["species"] = iri.target	

plt.style.use('dark_background')
plt.title("PCA on Iris Dataset")

colormap = {0:"#FF0000", 1:"#00FF00", 2:"#0000FF"} # setosa versicolor virginica
for s, group in reduced_df.groupby("species"):
	plt.scatter(group["PC1"], group["PC2"], label=iri.target_names[s], color=colormap[s])

plt.legend()
plt.xlabel("Principal Component 1")
plt.ylabel("Principal Component 2")
plt.show()
