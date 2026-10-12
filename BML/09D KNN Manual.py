train_x = [(1, 1), (1, 2), (2, 1), (5, 5), (6, 5), (5, 6)]
train_y = ["A", "A", "A", "B", "B", "B"]
K = 3


def distance(a, b):
    return ((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2) ** 0.5


def predict_knn(point):
    distances = []
    for i, sample in enumerate(train_x):
        distances.append((distance(point, sample), train_y[i]))
    distances.sort(key=lambda item: item[0])
    votes = {}
    for _, label in distances[:K]:
        votes[label] = votes.get(label, 0) + 1
    return max(votes, key=votes.get)


for point in [(2, 2), (5, 4), (3, 6), (2, 7), (6, 7), (4, 7)]:
    print("Point:", point, "Predicted class:", predict_knn(point))
