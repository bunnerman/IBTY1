p = int(input("Enter p: "))
n = int(input("Enter n: "))

a = int(input("Enter a: "))
b = int(input("Enter b: "))

pA = pow(n, a, p)
pB = pow(n, b, p)
print("Alice Public Key:", pA)
print("Bob Public Key:", pB)

sharedA = pow(pB, a, p)
sharedB = pow(pA, b, p)

if sharedA == sharedB:
	print("Both shared keys equal:", sharedA)
else:
	print("FAILURE")
