// Optimal

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
       // Create a new D.S for storing start and end together, its good to do this for interviews
       // for cleaner code rather than using an idx array sorted according to end times as done in Job Sequencing Problem (GFG) (Check on github)
    int[][] meeting = new int[n][2];
        // Create the meeting 2D array storing start and end times in pairs
    for (int i = 0; i < n; i++) {
        meeting[i][0] = start[i];
        meeting[i][1] = end[i];
    }
        // Sort the meetings according to their end times in ascending order
    Arrays.sort(meeting, (a, b) -> Integer.compare(a[1], b[1])); 
    int maxMeetings = 0;
    int lastMeetEndTime = -1;
        // Allocate the meetings
    for (int i = 0; i < n; i++) {
        // If curr meeting's start time is greater than last meeting's end time, allocate select this meeting
        if (meeting[i][0] > lastMeetEndTime) {
            // Update lastMeetEndTime to newly selected meeting's end time
            lastMeetEndTime = meeting[i][1];
            // Increment maxMeetings
            maxMeetings++;
        }
    }
    return maxMeetings;
    }
}
 
// T.C => O(n) + O(n * log(n)) + O(n) = O(2n + n * log(n)) = O(n * log(n))
// S.C => O(2*n) for the meeting 2D array
