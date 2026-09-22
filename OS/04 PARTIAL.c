// FCFS Scheduling Algorithm
#include <stdio.h>
void swap(int a, int b)
{
  int temp = a;
  a = b;
  b = temp;
}
void rearrangeList(int n, int at, int bt)
{
  for (int i = 0; i &lt; n; i++)
    {
        for (int j = i + 1; j &lt; n; j++)
        {
            if (at[i] &gt; at[j])
            {
                swap(&amp;at[i], &amp;at[j]);
                swap(&amp;bt[i], &amp;bt[j]);
            }
        }
    }
}

int main()
{
int n;
printf(&quot;Enter number of processes: &quot;);
int at[n], bt[n], ct[n], tat[n], wt[n];

printf(&quot;Enter Arrival Times (%d): &quot;, n);
for (int i = 0; i &lt; n; i++)
scanf(&quot;%d&quot;, &amp;at[i]);

printf("Enter Burst Times (%d): ", n);
