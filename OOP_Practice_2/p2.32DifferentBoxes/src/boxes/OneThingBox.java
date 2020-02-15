package boxes;

public class OneThingBox extends Box {

	private Thing oneThingOneOportunity = null;

	@Override
	public void add(Thing thing) {
		if (oneThingOneOportunity == null)
			oneThingOneOportunity = thing;
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		if (oneThingOneOportunity == null)
			return false;
		else
			return thing.getName() == oneThingOneOportunity.getName();
	}

}
