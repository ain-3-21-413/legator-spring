package kg.inai.legator.service.impl;

import kg.inai.legator.entity.item.AccessLevel;
import kg.inai.legator.entity.patron.Patron;
import kg.inai.legator.entity.patron.PatronGroup;
import kg.inai.legator.exception.PatronGroupNameTakenException;
import kg.inai.legator.mapper.UserMapper;
import kg.inai.legator.model.patrons.PatronGroupModel;
import kg.inai.legator.model.patrons.PatronModel;
import kg.inai.legator.model.user.CreateUserRequest;
import kg.inai.legator.repository.item.AccessLevelRepository;
import kg.inai.legator.repository.patron.PatronGroupRepository;
import kg.inai.legator.repository.patron.PatronRepository;
import kg.inai.legator.service.PatronService;
import kg.inai.legator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatronServiceImpl implements PatronService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PatronGroupRepository patronGroupRepository;
    private final PatronRepository patronRepository;
    @Override
    public PatronGroup createPatronGroup(PatronGroupModel patronGroupModel) {
        String name = patronGroupModel.name();
        int checkedOutCount = patronGroupModel.checkedOutCount();
        int checkedOutDuration = patronGroupModel.checkedOutDuration();
        int holdCount = patronGroupModel.holdCount();
        int holdDuration = patronGroupModel.holdDuration();
        boolean existsByName = patronGroupRepository.existsByName(name);
        if (existsByName) {
            throw new PatronGroupNameTakenException("Group Name: " + name  + " is taken");
        }
        PatronGroup patronGroup = PatronGroup.builder()
                .name(name)
                .checkedOutCount(checkedOutCount)
                .checkedOutDuration(checkedOutDuration)
                .holdCount(holdCount)
                .holdDuration(holdDuration)
                .build();

        return patronGroupRepository.save(patronGroup);
    }

    @Override
    public Patron createPatron(PatronModel patronModel) {
        String accessLevel = patronModel.accessLevel();
        String email = patronModel.email();
        String firstName = patronModel.firstName();
        String middleName = patronModel.middleName();
        String lastName = patronModel.lastName();
        String number = patronModel.number();
        String phone = patronModel.phone();
        CreateUserRequest user = patronModel.user();
        userService.createUser(user);
        boolean existsBy = patronRepository.existsByName(email);
        if (existsBy) {
            throw new PatronGroupNameTakenException("");}

        Patron patron = Patron.builder()
                .accessLevel(AccessLevel.valueOf(accessLevel))
                .email(email)
                .phone(phone)
                .user(userMapper.toEntity(userService.createUser(user)))
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .number(number)
                .build();



        return patronRepository.save(patron);

    }

    @Override
    public Patron editPatron(String id, PatronModel patronModel) {
        Patron patron = patronRepository.findById(id).orElseThrow();
        patron.setEmail(patronModel.email());
        String accessLevel = patronModel.accessLevel();
        patron.setAccessLevel(AccessLevel.valueOf(accessLevel));
        patron.setNumber(patronModel.number());
        patron.setPhone(patronModel.phone());
        patron.setFirstName(patronModel.firstName());
        patron.setMiddleName(patronModel.middleName());
        patron.setLastName(patronModel.lastName());



        return patronRepository.save(patron);
    }
}

