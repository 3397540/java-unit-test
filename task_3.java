import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)// Напиши аннотацию для параметризованных тестов
public class CheckIsAdultTest {
	
  private final int age;
  private final boolean result;

  public CheckIsAdultTest(int age, boolean result) {
	this.age = age;
    this.result = result;  // Инициализируй поля класса в конструкторе
  }

  @Parameterized.Parameters(name = "{index}: для возраста {0} значение совершеннолетия должно быть {1}") // Пометь метод аннотацией для параметров
  public static Object[][] getTextData() {
	return new Object[][] {
		{19, true},
        {17, false},
        {18, true},
        {20, true},// Заполни массив тестовыми данными и ожидаемым результатом
    };
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
	Program program = new Program();
	boolean isAdult = program.checkIsAdult(age);
	// Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
    assertEquals("Значение совершеннолетия должно совпадать", result, isAdult);
	}
}