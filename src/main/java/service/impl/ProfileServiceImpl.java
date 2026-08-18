package service.impl;

import model.Profile;
import repository.ProfileRepository;
import service.ProfileService;

public class ProfileServiceImpl extends BaseServiceImpl<Profile, Long, ProfileRepository> implements ProfileService {
    public ProfileServiceImpl(ProfileRepository repository) {
        super(repository);
    }

    @Override
    public void validation(Profile profile) {
        if (profile != null) {
            if (profile.getWebsite() == null || profile.getWebsite().isBlank()) {
                throw new IllegalArgumentException("Website can not be null or empty!");
            }
            if (profile.getBio() == null || profile.getBio().isBlank()) {
                throw new IllegalArgumentException("Biography can not be null!");
            }
            if (profile.getAuthor() == null) {
                throw new IllegalArgumentException("Author can not be null!");
            }
        } else {
            throw new IllegalArgumentException("New profile can not be null!");
        }
    }
}
