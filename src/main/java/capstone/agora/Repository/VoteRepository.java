package capstone.agora.Repository;

import capstone.agora.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository <Vote, Long> {

    Optional<Vote> getVoteByNum(int voteNum);

    @Query("select v.num, v.author, v.title, v.time from Vote v")
    List<Vote> getEntireVote();

    @Override
    void deleteAll();
}
