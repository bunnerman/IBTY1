#include <iostream>

using std::cout, std::cin;

long long int power(long long int base, long long int exp, long long int mod)
{
    long long int res = 1;
    base = base % mod;
    while (exp > 0)
    {
        if (exp % 2 == 1)
            res = (res * base) % mod;
        base = (base * base) % mod;
        exp /= 2;
    }
    return res;
}

int gcd(int a, int b)
{
    if (b == 0)
        return a;

    return gcd(b, a % b);
}

int main()
{
    int p, q;
    cout << "Enter two prime numbers (p and q): ";
    cin >> p >> q;

    int n = p * q;
    int phi = (p - 1) * (q - 1);

    int e = 2;
    while (e < phi)
    {
        if (gcd(e, phi) == 1)
            break;
        e++;
    }

    int d = 1;
    while ((d * e) % phi != 1)
    {
        d++;
    }

    cout << "\nPublic Key (e, n): (" << e << ", " << n << ")";
    cout << "\nPrivate Key (d, n): (" << d << ", " << n << ")\n";

    long long int msg;
    cout << "\nEnter message to encrypt (number < " << n << "): ";
    cin >> msg;

    long long int cipher = power(msg, e, n);
    cout << "Encrypted Message (Ciphertext): " << cipher << "\n";

    long long int decrypted = power(cipher, d, n);
    cout << "Decrypted Message: " << decrypted << "\n";

    return 0;
}
