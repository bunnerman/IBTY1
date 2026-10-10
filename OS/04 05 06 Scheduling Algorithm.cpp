// Code for FCFS, SJF and RR implementation

#include <iostream>
#include <vector>
#include <algorithm>

using std::cout, std::cin, std::string, std::vector, std::swap;

class ScheduleProcesses
{
private:
	int n;
	vector<int> at, bt, ct, tat, wt;
	vector<string> gh;
	
	int sjfHelper()
	{
		
	}
public:
	void acceptProcesses(vector<int> at, vector<int> bt)
	{
		this->n = n;
		this->at = at;
		this->bt = bt;
	}

	void rearrangeList()
	{
		int n = at.size();
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (at[i] > at[j])
				{
					swap(at[i], at[j]);
					swap(bt[i], bt[j]);
				}
	}

	int fcfs()
	{
		int t = 0;

		n = at.size();
		ct.clear(); tat.clear(); wt.clear();
		ct.resize(n); tat.resize(n); wt.resize(n);
		rearrangeList();

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

		return t;
	}
	int sjf()
	{
		n = at.size();
		ct.clear(); tat.clear(); wt.clear();
		ct.resize(n); tat.resize(n); wt.resize(n);
		rearrangeList();

		int t = 0;

		int tt = 0; // total time (required to finish)
		for (int &i : bt)
		tt += i;
		
		vector<int> rt = bt; // remaining time
		int cpi; // current process index

		for (int pt = 0; pt < tt; pt++) // present time
		{
							
		}
 
		return t;
	}
	int rr()
	{
		int t = 0;

		return t;
	}

	void printTimes()
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
};

int main()
{
	int n;
	cout << "Enter number of processes: "; 
	cin >> n;
	vector<int> at(n), bt(n);
	cout << "Enter Arrival Times (" << n << "): ";
	for (int i = 0; i < n; i++)
		cin >> at[i];

	cout << "Enter Burst Times (" << n << "): ";
	for (int i = 0; i < n; i++)
		cin >> bt[i];

	ScheduleProcesses obj;
	obj.acceptProcesses(at, bt);
	obj.fcfs();
	obj.printTimes();
}
