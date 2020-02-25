package socialnetwork;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;

public class SocialNetworkImpl
		implements lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork, Comparable<Object> {
	Set<Friend> friendSet = new HashSet<>();

	@Override
	public void addFriend(Friend friend) {
		if (friend == null)
			throw new IllegalArgumentException();
		friendSet.add(friend);

	}

	@Override
	public Collection<Friend> findByCity(String city) {
		if (city == null)
			throw new IllegalArgumentException();
		return friendSet.stream().filter(x -> x.getCity().equals(city)).collect(Collectors.toList());
	}

	@Override
	public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
		if (firstName == null || lastName == null)
			throw new IllegalArgumentException();

		for (Friend friend : friendSet) {
			if (friend.getFirstName().equals(firstName) && friend.getLastName().equals(lastName)) {
				return friend;
			}
		}

		throw new FriendNotFoundException(firstName, lastName);

	}

	@Override
	public int getNumberOfFriends() {
		return friendSet.size();
	}

	@Override
	public Collection<Friend> getOrderedFriends() {
		return friendSet.stream().sorted(
				comparing(Friend::getCity).thenComparing(Friend::getLastName).thenComparing(Friend::getFirstName))
				.collect(toList());
	}

	@Override
	public int compareTo(Object var1) {
		return 0;
	}

}
