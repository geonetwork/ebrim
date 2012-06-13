package org.geonetwork.gaap.services.authorization;

import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.services.MetadataPermissionsService;
import org.geonetwork.gaap.services.authentication.AuthenticationManager;
import org.geonetwork.gaap.domain.user.User;

import java.util.Set;
import java.util.HashSet;

/**
 * Authorization manager
 *
 * @author Jose
 */
public final class AuthorizationManager {
    public static final String PROFILE_ADMIN = "Administrator";
    public static final String PROFILE_USER_ADMIN = "UserAdmin";
    public static final String PROFILE_ANONYMOUS = "Anonymous";
    public static final String PROFILE_EDITOR = "Editor";
    public static final String PROFILE_REVIEWER = "Reviewer";

    private AuthenticationManager authenticationManager;

    private Set<Authorization> authorizations;


    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AuthorizationManager() {
        initAuthorizations();
    }


    public boolean hasAuthorization(Class service, String request, String authToken) {
        // Verify token and update the last time usage
        User user = authenticationManager.verifyToken(authToken);

        // Try first for Anonymous
        Authorization authorizationToCheck = new Authorization(service, request, AuthorizationManager.PROFILE_ANONYMOUS);
        if (authorizations.contains(authorizationToCheck)) return true;

        if (user != null) {
            authorizationToCheck = new Authorization(service, request, user.getProfile());
            return authorizations.contains(authorizationToCheck);

        } else {
            return false;
        }
        
    }

    /**
     * Static initialization of Authorizations
     * 
     */
    private void initAuthorizations() {
        authorizations = new HashSet<Authorization>();

        // Authorizations for GroupService
        authorizations.add(new Authorization(GroupService.class, "retrieveGroup", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(GroupService.class, "retrieveAllGroups", PROFILE_ANONYMOUS));

        authorizations.add(new Authorization(GroupService.class, "createGroup", PROFILE_ADMIN));
        authorizations.add(new Authorization(GroupService.class, "updateGroup", PROFILE_ADMIN));
        authorizations.add(new Authorization(GroupService.class, "deleteGroup", PROFILE_ADMIN));

        // Authorizations for UserService
        authorizations.add(new Authorization(UserService.class, "retrieveUser", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(UserService.class, "retrieveUserByUsername", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(UserService.class, "retrieveAllUsers", PROFILE_ANONYMOUS));

        authorizations.add(new Authorization(UserService.class, "createUser", PROFILE_ADMIN));
        authorizations.add(new Authorization(UserService.class, "updateUser", PROFILE_ADMIN));
        authorizations.add(new Authorization(UserService.class, "deleteUser", PROFILE_ADMIN));

        authorizations.add(new Authorization(UserService.class, "updateUser", PROFILE_USER_ADMIN));
        authorizations.add(new Authorization(UserService.class, "updateUser", PROFILE_EDITOR));
        authorizations.add(new Authorization(UserService.class, "updateUser", PROFILE_REVIEWER));


        // Authorizations for MetadataPermissionsService
        authorizations.add(new Authorization(MetadataPermissionsService.class, "getOperation", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "getOperations", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "getPermissions", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "filterMetadata", PROFILE_ANONYMOUS));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "filterMetadataByGroups", PROFILE_ANONYMOUS));

        authorizations.add(new Authorization(MetadataPermissionsService.class, "saveMetadataPermission", PROFILE_ADMIN));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "deleteMetadataPermission", PROFILE_ADMIN));
        authorizations.add(new Authorization(MetadataPermissionsService.class, "savePermissions", PROFILE_ADMIN));                 
    }

}
