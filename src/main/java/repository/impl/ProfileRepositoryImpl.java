package repository.impl;

import model.Profile;
import repository.ProfileRepository;

public class ProfileRepositoryImpl extends BaseRepositoryImpl<Profile, Long> implements ProfileRepository {
    @Override
    public Class<Profile> getEntityClass() {
        return Profile.class;
    }

    @Override
    public void settingAttributes(Profile upgradingProfile, Profile newProfile) {
        upgradingProfile.setWebsite(newProfile.getWebsite());
        upgradingProfile.setAuthor(newProfile.getAuthor());
        upgradingProfile.setBio(newProfile.getBio());
    }
}

