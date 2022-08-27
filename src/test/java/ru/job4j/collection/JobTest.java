package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("job1", 2),
                new Job("job2", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("job2", 1),
                new Job("job1", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("job2", 1),
                new Job("job1", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("job1", 2),
                new Job("job2", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndAscByPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("job", 1),
                new Job("job", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("job", 2),
                new Job("job", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}