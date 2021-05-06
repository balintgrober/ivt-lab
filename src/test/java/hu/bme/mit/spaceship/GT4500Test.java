package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;

  TorpedoStore mock_primaryStore;
  TorpedoStore mock_secondaryStore;

  @BeforeEach
  public void init(){
    mock_primaryStore = mock(TorpedoStore.class);
    mock_secondaryStore = mock(TorpedoStore.class);
    this.ship = new GT4500(mock_primaryStore, mock_secondaryStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mock_primaryStore.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    verify(mock_primaryStore, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mock_primaryStore.fire(1)).thenReturn(true);
    when(mock_secondaryStore.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);

    verify(mock_primaryStore, times(1)).fire(1);
    verify(mock_secondaryStore, times(1)).fire(1);
  }

}
