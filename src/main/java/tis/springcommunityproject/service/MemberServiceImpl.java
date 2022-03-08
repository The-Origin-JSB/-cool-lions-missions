package tis.springcommunityproject.service;

import org.springframework.stereotype.Service;
import tis.springcommunityproject.domain.UserEntity;
import tis.springcommunityproject.repository.JpaUserRepository;

@Service
public class MemberServiceImpl implements MemberService{

	private final JpaUserRepository userRepository;

	public MemberServiceImpl(JpaUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity join(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity edit(Long id, UserEntity user) {
		UserEntity findUser = userRepository.findById(id).orElseThrow(NotFoundDataException::new);
		findUser.updateName(user.getName());
		return findUser;
	}

	@Override
	public UserEntity findOne(Long id) {
		return userRepository.findById(id).orElseThrow(NotFoundDataException::new);
	}

	@Override
	public void deleteOne(Long id) {
		userRepository.deleteById(id);
	}
}
