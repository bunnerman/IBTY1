import numpy as np
import pandas as pd
from sklearn.preprocessing import LabelEncoder, MinMaxScaler

df = pd.read_csv("iris.csv", na_values=[''])

print(df.info())
vals = df.select_dtypes(include=["float64", "int64"]).columns
df[vals] = df[vals].fillna(df[vals].mean())

scaler = MinMaxScaler()
df[vals] = scaler.fit_transform(df[vals])

encoder = LabelEncoder()
df["Type"] = encoder.fit_transform(df["Type"])

print(df)
print(df.info())
