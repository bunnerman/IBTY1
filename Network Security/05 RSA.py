from Crypto.Util.number import GCD, inverse, getPrime

p = getPrime(512)
q = getPrime(512)

n = p * q
phi = (p - 1) * (q - 1)

e = 65537
while e < phi:
    if GCD(e, phi) == 1:
        break
    e += 1

d = inverse(e, phi)

msg_str = input("Enter message to encrypt: ")

msg_int = int.from_bytes(msg_str.encode('utf-8'), 'big')

cipher = pow(msg_int, e, n)
print("Encrypted:", cipher)

dec_int = pow(cipher, d, n)
dec_str = dec_int.to_bytes((dec_int.bit_length() + 7) // 8, 'big').decode('utf-8')
print("Decrypted:", dec_str)
