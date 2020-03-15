import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.test.BaseTest;

public class BaseTestImpl extends BaseTest {

	@Override
	protected Exercises createExercises() {
		return new ExcersiceImpl();
	}

}
