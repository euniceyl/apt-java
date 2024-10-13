import java.util.*;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        int riggedVotes = 0;
        if (votes.length == 1) {
            return 0;
        }

        int[] otherCand = new int[votes.length - 1];
        for (int i=0; i<otherCand.length; i++) {
            otherCand[i] = votes[i+1];
        }
        Arrays.sort(otherCand);

        while(riggedVotes + votes[0] <= otherCand[otherCand.length-1]) {
            otherCand[otherCand.length-1] = otherCand[otherCand.length-1] - 1;
            riggedVotes ++;
            Arrays.sort(otherCand);
        }

        return riggedVotes;
    }
}
