package com.ftn.agent.model.forDatabase;

import com.ftn.agent.model.Address;
import com.ftn.agent.model.Agent;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "agents")
public class AgentForDatabase implements Serializable, UserDetails {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @OneToOne
    private Address address;

    private int companyNumber;

    private String username;

    private String email;

    private String password;

    private boolean isAccepted;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "agent_role",
            joinColumns = @JoinColumn(name = "agent_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;


    public AgentForDatabase () {

    }

    public AgentForDatabase(Agent agent){
    //    this.address = agent.getAddress();
        this.name = agent.getName();
        this.surname = agent.getSurname();
        this.email = agent.getEmail();
        this.username = agent.getUsername();
        this.companyNumber = agent.getCompanyNumber();
        this.password = agent.getPassword();
        this.isAccepted = agent.isIsAccepted();
//        Role role = this.roleRepository.findRoleByName("ROLE_AGENT");
//        List<Role> authorities = new ArrayList<>();
//        authorities.add(role);
//        agent.setRoles(authorities);
//        agent.setLastPasswordResetDate(new Timestamp(DateTime.now().getMillis()));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set privileges = new HashSet();

        for (Role role : this.roles) {
            Collection<Privilege> allPrivileges = role.getPrivileges();
            for (Privilege privilege : allPrivileges) {
                privileges.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }
        return privileges;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
