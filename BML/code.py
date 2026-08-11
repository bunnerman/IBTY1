import numpy as np
import pandas as pd
from sklearn.preprocessing import LabelEncoder, MinMaxScaler

# 1. Load data
df = pd.read_csv("iris.csv")

# 2. Fill empty columns with their mathematical averages (means)
num_vals = df.select_dtypes(include=["float64", "int64"]).columns
df[num_vals] = df[num_vals].fillna(df[num_vals].mean())

# 3. Scale numerical length and width features to [0, 1] range
scaler = MinMaxScaler()
df[num_vals] = scaler.fit_transform(df[num_vals])

# 4. Encode categorical species labels into integers (0, 1, 2)
encoder = LabelEncoder()
df["Type"] = encoder.fit_transform(df["Type"])

print(df)