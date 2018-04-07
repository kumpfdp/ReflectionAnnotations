package labs.solutions.metadata.lab2;

/**
 * 
 * @author Anil Pal
 *
 */
public class Car
{
	@UpperCase(length=3)
	@Length(max = 4)
    private String modelName;
    
    private int numWheels;
    
    private int numDoors;

    public String getModelName ()
    {
        return modelName;
    }

    public void setModelName (String modelName)
    {
        this.modelName = modelName;
    }

    public int getNumWheels ()
    {
        return numWheels;
    }

    public void setNumWheels (int numWheels)
    {
        this.numWheels = numWheels;
    }

    public int getNumDoors ()
    {
        return numDoors;
    }

    public void setNumDoors (int numDoors)
    {
        this.numDoors = numDoors;
    }

	@Override
	public String toString() {
		return "Car [modelName=" + modelName + ", numWheels=" + numWheels
				+ ", numDoors=" + numDoors + "]";
	}
    
    
}
