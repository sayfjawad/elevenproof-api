package nl.multicode.elevenproof.validate;

import static org.assertj.core.api.Assertions.assertThat;

import nl.multicode.elevenproof.validate.proof.BankAccountElevenProof;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BankaccountElevenProofTest {

  private BankAccountElevenProof bankAccountElevenProof;

  @BeforeEach
  public void setup() {

    bankAccountElevenProof = new BankAccountElevenProof();
  }

  @ParameterizedTest
  @CsvSource({"0609567128", "0152180192", "0156575477", "0154858838"})
  @DisplayName("Given that the isElevenProof is doing the BankAccount proof correctly "
      + "When the method is called with a valid account number"
      + "Then TRUE is returned")
  void isElevenProof_True(String number) {

    assertThat(bankAccountElevenProof.isElevenProof(getArray(number))).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"1112223301", "0177177771", "2212220231", "1209786511"})
  @DisplayName("Given that the isElevenProof is doing the BankAccount proof correctly "
      + "When the method is called with an invalid BankAccount number"
      + "Then FALSE is returned")
  void isElevenProof_False(String number) {

    assertThat(bankAccountElevenProof.isElevenProof(getArray(number))).isFalse();
  }

  private int[] getArray(String number) {

    return number.chars().map(Character::getNumericValue).toArray();
  }
}