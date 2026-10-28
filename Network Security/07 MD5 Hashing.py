from Crypto.Hash import MD5

text = input("Enter text: ")

h = MD5.new()
h.update(text.encode())
hashed = h.hexdigest()

print("MD5 Hash:", hashed)
