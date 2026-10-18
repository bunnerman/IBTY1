#include <stdio.h>

void fifoPageSchedule(int refStr[], int n, int fn)
{
	// for <C99 just use 0 and 1 for false and true and if >C23 just use bool without needing stdbool.h
	int alot = false;
	int oldestIndex = 0;

	int frames[fn];
	for (int i = 0; i < fn; i++)
		frames[i] = -1;

	for (int i = 0; i < n; i++)
	{
		alot = false;
		int hit = false;
		for (int j = 0; j < fn; j++)
		{
			if (frames[j] == refStr[i])
			{
				hit = true;
				printf("HIT on %d at frame no. %d\n", frames[j], j);
				alot = true;
				break;
			}	
		}

		if (!hit)
		{
			for (int j = 0; j < fn; j++)
				if (frames[j] == -1)
				{
					printf("PF: %d placed at frame no. %d\n", refStr[i], j);
					frames[j] = refStr[i];
					alot = true;
					break;
				}
		}

		if (!alot)
		{
			printf("PF: %d replaced w/ %d in frame no. %d\n", frames[oldestIndex], refStr[i], oldestIndex); //* OUT
			frames[oldestIndex] = refStr[i];
			if (oldestIndex == fn - 1)
				oldestIndex = 0;
			else 
				oldestIndex = oldestIndex + 1;

		}
	}
}

int main()
{
	int refStr[8] = {7, 0, 1, 2, 0, 3, 0, 4};

	fifoPageSchedule(refStr, 8, 3);

    return 0;
}
