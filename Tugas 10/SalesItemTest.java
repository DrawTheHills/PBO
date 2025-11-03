
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesItemTest {
    private SalesItem item;

    @BeforeEach
    public void setUp() {
        item = new SalesItem("Item1", 239);
    }

    @Test
    public void testAddComment() {
        assertTrue(item.addComment("Opal", "good", 5));
    }

    @Test
    public void testIllegalRating() {
        assertFalse(item.addComment("Opal", "bad", 0));
    }

    @Test
    public void testDuplicateAuthor() {
        assertTrue(item.addComment("Opal", "good", 5));
        assertFalse(item.addComment("Opal", "hmmmm", 3));
    }

    @Test
    public void testUpvoteDownvoteComment() {
        assertTrue(item.addComment("Bima", "Comfortable and stylish", 4));

        item.upvoteComment(0);
        item.upvoteComment(0);
        item.downvoteComment(0);

        Comment c = item.findCommentByAuthor("Bima");
        assertNotNull(c, "Komentar oleh Malvin harus ada");
        assertEquals(1, c.getVoteCount(), "Net vote harus 1 setelah 2 upvote dan 1 downvote");
    }

    @Test
    public void Test1()
    {
    }
}

