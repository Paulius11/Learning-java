package socialnetwork;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class BaseSocialNetworkTests extends BaseSocialNetworkTest {

	@Override
	protected SocialNetwork getSocialNetwork() {

		return new socialnetwork.SocialNetworkImpl();
	}

}
