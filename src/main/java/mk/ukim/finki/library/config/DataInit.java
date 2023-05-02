package mk.ukim.finki.library.config;

import lombok.Data;
import mk.ukim.finki.library.dto.BookDto;
import mk.ukim.finki.library.enumerations.Category;
import mk.ukim.finki.library.enumerations.Role;
import mk.ukim.finki.library.exceptions.AuthorNotFoundException;
import mk.ukim.finki.library.exceptions.CountryNotFoundException;
import mk.ukim.finki.library.model.Author;
import mk.ukim.finki.library.model.Book;
import mk.ukim.finki.library.model.Country;
import mk.ukim.finki.library.service.AuthorService;
import mk.ukim.finki.library.service.BookService;
import mk.ukim.finki.library.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
@Data
public class DataInit {
    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInit(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }



    @PostConstruct
    public void init() {

        Country USA = countryService.create("USA", "America")
                .orElseThrow(() -> new RuntimeException());;
        Country France = countryService.create("France", "Europe")
                .orElseThrow(() -> new RuntimeException());
        Country Macedonia = countryService.create("North Macedonia", "Europe")
                .orElseThrow(() -> new RuntimeException());
        Country Nigeria = countryService.create("Nigeria", "Africa")
                .orElseThrow(() -> new RuntimeException());
        Country England = countryService.create("England", "Europe")
                .orElseThrow(() -> new RuntimeException());
        Country India = countryService.create("India", "Asia")
                .orElseThrow(() -> new RuntimeException());
        Country Russia = countryService.create("Russia", "Europe")
                .orElseThrow(() -> new RuntimeException());
        // ************************************************************************


        Author author1 = authorService.create("Harper", "Lee", USA)
                .orElseThrow(() -> new CountryNotFoundException(USA.getId()));
        Author author2 = authorService.create("Pascal", "Garnier", France)
                .orElseThrow(() -> new CountryNotFoundException(France.getId()));
        Author author3 = authorService.create("Vojdan", "Chernodrinski", Macedonia)
                .orElseThrow(() -> new CountryNotFoundException(Macedonia.getId()));
        Author author4 = authorService.create("Amos", "Tutuola", Nigeria)
                .orElseThrow(() -> new CountryNotFoundException(Nigeria.getId()));
        Author author5 = authorService.create("Stephen", "Hawking", England)
                .orElseThrow(() -> new CountryNotFoundException(England.getId()));
        Author author6 = authorService.create("Mahatma", "Gandhi", India)
                .orElseThrow(() -> new CountryNotFoundException(India.getId()));
        Author author7 = authorService.create("William", "Shakespeare ", England)
                .orElseThrow(() -> new CountryNotFoundException(England.getId()));
        Author author8 = authorService.create("Fyodor", "Dostoevsky", Russia)
                .orElseThrow(() -> new CountryNotFoundException(Russia.getId()));
        Author author9 = authorService.create("Colleen", "Hoover", USA)
                .orElseThrow(() -> new CountryNotFoundException(USA.getId()));
        //***************************************************************************

        Book book1 = bookService.create("To Kill a Mockingbird", Category.NOVEL, author1.getId(), 85)
                .orElseThrow(() -> new AuthorNotFoundException(author1.getId()));
        Book book2 = bookService.create("Makedonska krvava svadba", Category.DRAMA, author3.getId(), 50)
                .orElseThrow(() -> new AuthorNotFoundException(author3.getId()));
        Book book3 = bookService.create("How's the pain?", Category.THRILER, author2.getId(), 323)
                .orElseThrow(() -> new AuthorNotFoundException(author2.getId()));
        Book book4 = bookService.create("My Life in the Bush of Ghosts", Category.FANTASY, author4.getId(), 254)
                .orElseThrow(() -> new AuthorNotFoundException(author4.getId()));
        Book book5 = bookService.create("A Brief History of Time", Category.HISTORY, author5.getId(), 54)
                .orElseThrow(() -> new AuthorNotFoundException(author5.getId()));
        Book book6 = bookService.create("The Story of My Experiments with Truth", Category.BIOGRAPHY, author6.getId(), 998)
                .orElseThrow(() -> new AuthorNotFoundException(author6.getId()));
        Book book7 = bookService.create("Hamlet", Category.CLASSICS, author7.getId(), 1045)
                .orElseThrow(() -> new AuthorNotFoundException(author7.getId()));
        Book book8 = bookService.create("Crime and punishment", Category.CLASSICS, author8.getId(), 16)
                .orElseThrow(() -> new AuthorNotFoundException(author8.getId()));
        Book book9 = bookService.create("Verity", Category.CLASSICS, author9.getId(), 59)
                .orElseThrow(() -> new AuthorNotFoundException(author9.getId()));
    }

}