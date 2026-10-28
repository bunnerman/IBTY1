from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256

doc, key = b"original", RSA.generate(2048)
sig = pkcs1_15.new(key).sign(SHA256.new(doc))

verify = lambda d: pkcs1_15.new(key.publickey()).verify(SHA256.new(d), sig) is None

print("OG Valid?", verify(doc))

tdoc = b"tampered"

try:
    verify(tdoc)
except (ValueError, TypeError):
    print("Tampered")
