import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MaryamBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        Message input = update.getMessage();
        String text = input.getText();
        long chatId = input.getChatId();
        String heart = EmojiParser.parseToUnicode(":heart:");
        String pointDown = EmojiParser.parseToUnicode(":point_down:");

        ReplyKeyboardMarkup options = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyList = new ArrayList<>();

        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add("first name");
        firstRow.add("last name");
        firstRow.add("age");
        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add("telegram ID");
        secondRow.add("phone number");
        secondRow.add("location");

        keyList.add(firstRow);
        keyList.add(secondRow);

        options.setKeyboard(keyList);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setReplyMarkup(options);
        String message;

        List<Account> persons = new ArrayList<>();
        Account account = new Account();
        ForceReplyKeyboard replay = new ForceReplyKeyboard();
        replay.setSelective(true);

        try {
            switch (text) {
                case "/start":
                    message = String.format("Hi. Welcome to Maryam's Bot " + heart +
                            "%nPlease select one button to enter the information " + pointDown);
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "first name":
                    message = String.format("Please enter your first name: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    account.setLastName(input.getText());
                    message = String.format("Your first name has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "last name":
                    message = String.format("Please enter your last name: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    account.setLastName(input.getText());
                    message = String.format("Your last name has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "age":
                    message = String.format("Please enter your age: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
//                    p.setAge(Byte.parseByte(input.getText()));
                    message = String.format("Your age has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "telegram ID":
                    message = String.format("Please enter your telegram ID: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    account.setTelegramId(input.getText());
                    message = String.format("Your telegram ID has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "phone number":
                    message = String.format("Please enter your phone number: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
//                    p.setPhoneNumber(Long.parseLong(input.getText()));
                    message = String.format("Your phone number has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                case "location":
                    message = String.format("Please enter your location: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    account.setLocation(input.getText());
                    message = String.format("Your location has been set.");
                    sendMessage.setText(message);
                    execute(sendMessage);
                    break;
                default:
                    message = String.format("Please choose one of the buttons: ");
                    sendMessage.setText(message);
                    execute(sendMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            execute(sendMessage);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public String getBotUsername() {
        return "mapsaaaa_bot";
    }

    @Override
    public String getBotToken() {
        return "bot-token";
    }
}
