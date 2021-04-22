public class BookAdapter extends Book {
    IncompatibleBook incompatibleBook = new IncompatibleBook();

    @Override
    public void setTitleString(String aString) {
        incompatibleBook.setTitle(aString);
    }

    @Override
    public String getTitleString() {
        return incompatibleBook.getTitle();
    }
}
