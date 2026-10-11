x = [1, 2, 3, 4, 5, 6]
y = [1, 4, 9, 16, 27, 36]
degree = 2

sx = [sum(v**p for v in x) for p in range(2 * degree + 1)]
sxy = [sum((x[i]**p) * y[i] for i in range(len(x))) for p in range(degree + 1)]

A = [[sx[i + j] for j in range(degree + 1)] for i in range(degree + 1)]
b = sxy[:]

for i in range(degree + 1):
    pivot = A[i][i]
    for j in range(i, degree + 1):
        A[i][j] /= pivot
    b[i] /= pivot

    for k in range(degree + 1):
        if k != i:
            factor = A[k][i]
            for j in range(i, degree + 1):
                A[k][j] -= factor * A[i][j]
            b[k] -= factor * b[i]

coef = b  # [b0, b1, b2]

def predict_poly(v):
    return sum(coef[p] * (v**p) for p in range(degree + 1))


print("Coefficients:", [round(c, 3) for c in coef])

for i in range(7, 15):
    print(f"x={i}: {round(predict_poly(i), 2)}")
