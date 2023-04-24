package kg.inai.legator.entity.bibliographicrecord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.marc4j.marc.Subfield;

public class SubfieldImpl implements Subfield {

	private Long id;

    private char code;

    private String data;

    /**
     * Creates a new <code>Subfield</code>.
     */
    public SubfieldImpl() {
    }

    /**
     * Creates a new <code>Subfield</code> and sets the data element identifier.
     * 
     * @param code the data element identifier
     */
    public SubfieldImpl(final char code) {
        this.setCode(code);
    }

    /**
     * Creates a new <code>Subfield</code> and sets the data element identifier
     * and the data element.
     * 
     * @param code the data element identifier
     * @param data the data element
     */
    public SubfieldImpl(final char code, final String data) {
        this.setCode(code);
        this.setData(data);
    }

    /**
     * Sets the {@link Subfield} code.
     */
    @Override
    public void setCode(final char code) {
        this.code = code;
    }

    /**
     * Gets the {@link Subfield} code.
     */
    @Override
    public char getCode() {
        return code;
    }

    /**
     * Sets the {@link Subfield} data.
     */
    @Override
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Gets the {@link Subfield} data.
     */
    @Override
    public String getData() {
        return data;
    }

    /**
     * Returns <code>true</code> is the supplied regular expression pattern
     * matches the {@link Subfield} data; else, <code>false</code>.
     */
    @Override
    public boolean find(final String pattern) {
        final Pattern p = Pattern.compile(pattern);
        final Matcher m = p.matcher(getData());

        return m.find();
    }

    /**
     * Returns a string representation of this subfield.
     * <p>
     * Example:
     * 
     * <pre>
     * $aSummerland /
     * </pre>
     * 
     * @return String - a string representation of this subfield
     */
    @Override
    public String toString() {
        return "$" + getCode() + getData();
    }

    /**
     * Sets the ID for this {@link Subfield}.
     */
    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the ID for this {@link Subfield}.
     */
    @Override
    public Long getId() {
        return id;
    }
}
