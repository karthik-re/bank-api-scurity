package org.example.bankapi.config;

//Not using this class since we are using our own username and password authentication provider

//@Service
//should implement UserDetailsService
public class CustomUserDetails  {

//    private final CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomUserDetails(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Customer user = customerRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole()));
//
//        return new User(user.getEmail(), user.getPassword(),authorities);
//    }
}
