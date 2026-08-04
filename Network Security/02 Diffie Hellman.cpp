#include <iostream>

using std::cout, std::cin;

long long int expo(int base, int exponent)
{
	if (exponent == 0)
		return 1;
	else
		return base * expo(base, exponent - 1);
}

int main()
{
	int p, n; // prime and base generator
	cout << "Enter the common prime number and base generator: ";
	cin >> p >> n;
	int a, b; // private keys
	cout << "Enter private keys of Alice and Bob: ";
	cin >> a >> b;
	int pA = expo(n, a) % p;
	int pB = expo(n, b) % p;
	int sharedA = expo(pB, a) % p;
	int sharedB = expo(pA, b) % p;
	
	if (sharedA == sharedB)
		cout << "Both shared keys equal, exchange successful\n" << sharedA;
	else
		cout << "FAILED";
}