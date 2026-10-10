import math

x_raw = [1, 2, 3, 4, 5, 6]
y = [0, 0, 0, 1, 1, 1]
x = [v / 6 for v in x_raw]  # scale inputs
w, b = 0.0, 0.0
rate, epochs, n = 0.5, 3000, len(x)


def sigmoid(z):
    z = max(-500, min(500, z))  # avoid overflow
    return 1 / (1 + math.exp(-z))


for epoch in range(epochs):
    dw, db = 0.0, 0.0
    for i in range(n):
        p = sigmoid(w * x[i] + b)
        dw += (p - y[i]) * x[i]
        db += p - y[i]
    w -= rate * dw / n
    b -= rate * db / n


def classify(hours):
    p = sigmoid(w * (hours / 6) + b)
    return p, (1 if p >= 0.5 else 0)


for hours in [2, 5]:
    p, label = classify(hours)
    print(hours, "hours -> probability", round(p, 3), "class", label)

correct = sum(classify(h)[1] == y[i] for i, h in enumerate(x_raw))
