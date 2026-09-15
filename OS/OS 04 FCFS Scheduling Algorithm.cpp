// FCFS Scheduling Algorithm

#include <iostream>
#include <vector>
#include <algorithm>

using std::cout, std::cin, std::string, std::vector, std::swap;

void rearrangeList(int n, vector<int>& at, vector<int>& bt)
{
	for (int i = 0; i < n; i++)
		for (int j = i + 1; j < n; j++)
			if (at[i] > at[j])
			{
				swap(at[i], at[j]);
                swap(bt[i], bt[j]);
			}
}

int main()
{
	int n;
	cout << "Enter number of processes: ";
	cin >> n;
	vector<int> at(n), bt(n), ct(n), tat(n), wt(n);
	cout << "Enter Arrival Times (" << n << "): ";
	for (int &i : at)
		cin >> i;
	cout << "Enter Burst Times (" << n << "): ";
	for (int &i : bt)
		cin >> i;

	rearrangeList(n, at, bt);


	int t = 0;
	for (int i = 0; i < n; i++)
	{
		if (at[i] > t) // if idle time
			t = at[i] + bt[i];
		else
			t += bt[i]; 
		
		ct[i] = t;
		tat[i] = ct[i] - at[i];
		wt[i] = tat[i] - bt[i];
	}

	cout << "\nCompletion Time: ";
	for (int &i : ct)
		cout << i << " ";

	float avgtat = 0, avgwt = 0;
	cout << "\nTurn Around Time: ";
	for (int &i : tat)
	{
		cout << i << " ";
		avgtat += i;
	}
	cout << "\nWaiting Time: ";
	for (int &i : wt)
	{
		cout << i << " ";
		avgwt += i;
	}

	avgtat /= n; avgwt /= n;
	cout << "\nAverage Turn Around Time: " << avgtat << "\n";
	cout << "Average Waiting Time: " << avgwt << "\n";
}
