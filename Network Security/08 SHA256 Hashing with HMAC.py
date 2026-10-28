from Crypto.Hash import HMAC, SHA256

sk = b"key"

m1 = b"HelloWorld"
hmac1 = HMAC.new(sk, m1, digestmod=SHA256)
print("M1 MAC:", hmac1.hexdigest())

m2 = b"Very Long Message for Testing"
hmac2 = HMAC.new(sk, m2, digestmod=SHA256)
print("M2 MAC:", hmac2.hexdigest())

m1m = b"Helloworld" # W to w
hmac1m = HMAC.new(sk, m1m, digestmod=SHA256)
print("Modified MAC:", hmac1m.hexdigest())

sk2 = b"key2"
hmacsk2 = HMAC.new(sk2, m1, digestmod=SHA256) 

print(hmac1.hexdigest() == hmac2.hexdigest())
print(hmac1.hexdigest() == hmac1m.hexdigest())
print(hmac1.hexdigest() == hmacsk2.hexdigest())
