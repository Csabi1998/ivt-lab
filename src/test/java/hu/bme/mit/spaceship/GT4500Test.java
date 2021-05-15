package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockedTorpedoFirst;
  private TorpedoStore mockedTorpedoSecond;

  @BeforeEach
  public void init(){
    mockedTorpedoFirst = mock(TorpedoStore.class);
    mockedTorpedoSecond = mock(TorpedoStore.class);
    this.ship = new GT4500(mockedTorpedoFirst, mockedTorpedoSecond);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockedTorpedoFirst.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
    verify(mockedTorpedoFirst, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockedTorpedoFirst.fire(1)).thenReturn(true);
    when(mockedTorpedoSecond.fire(1)).thenReturn(true);
    when(mockedTorpedoFirst.isEmpty()).thenReturn(false, true);
    when(mockedTorpedoSecond.isEmpty()).thenReturn(false, true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    verify(mockedTorpedoFirst, times(1)).fire(1);
    verify(mockedTorpedoSecond, times(1)).fire(1);
  }

}
