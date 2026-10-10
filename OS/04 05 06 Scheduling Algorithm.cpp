// Code for FCFS, 
// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE// STILL INCOMLPLETE
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

void printTimes(int n, vector<int>& at, vector<int>& bt, vector<int>& ct, vector<int>& tat, vector<int>& wt)
{
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

struct Process
{
	int at, bt, ct, tat, wt;
};

class SchedulingAlgorithm
{
private:
	int n;
	int t = 0;
	vector<int> at, bt, ct, tat, wt;
public:
	SchedulingAlgorithm(int n, vector<int>& at, vector<int>& bt)
	{
		this->n = n;
		this->at = at;
		this->bt = bt;
		rearrangeList(n, this->at, this->bt);
	}
	int fcfs()
	{
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

		printTimes(n, at, bt, ct, tat, wt);
		return t;
	}
	int sjf()
	{

	}
	int rr()
	{

	}
};


int main()
{
	int n;
	cout << "Enter number of processes: "; cin >> n;
	vector<int> at(n), bt(n);
	cout << "Enter Arrival Times (" << n << "): "; for (int &i : at) cin >> i;
	cout << "Enter Burst Times (" << n << "): "; for (int &i : bt) cin >> i;

	SchedulingAlgorithm obj(n, at, bt);
	obj.fcfs();
	obj.sjf();
	obj.rr();
}
