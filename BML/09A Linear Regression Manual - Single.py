x = [1, 2, 3, 4, 5]
y = [35, 40, 50, 55, 65]
n = len(x)
xm, ym = sum(x) / n, sum(y) / n
num = sum((x[i] - xm) * (y[i] - ym) for i in range(n))
den = sum((v-xm) ** 2 for v in x)
b1 = num / den
b0 = ym - b1 * xm
def predict(v):
	return b0 + b1 * v

print("Intercept:", round(b0, 2))
print("Slope:", round(b1, 2))
print("Predicted marks for 6 hours:", round(predict(6), 2))
pred = [predict(v) for v in x]
mse = sum((y[i] - pred[i]) ** 2 for i in range(n)) / n
print("Training MSE:", round(mse, 2))
