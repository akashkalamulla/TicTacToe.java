package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private char[] board = new char[9];
    private char currentPlayer = 'X';

    private JButton[] buttons;

    public TicTacToeGUI() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeBoard();
        setupUI();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(index);
                }
            });
            panel.add(buttons[i]);
        }

        add(panel);
    }

    private void handleButtonClick(int index) {
        if (board[index] == ' ') {
            board[index] = currentPlayer;
            buttons[index].setText(Character.toString(currentPlayer));
            if (isVictory(currentPlayer)) {
                JOptionPane.showMessageDialog(this, currentPlayer + " Wins! Congratulations!");
                resetGame();
            } else if (isDraw()) {
                JOptionPane.showMessageDialog(this, "The game is a draw!");
                resetGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        } else {
            JOptionPane.showMessageDialog(this, "That space is taken!");
        }
    }

    private boolean isVictory(char icon) {
        if ((board[0] == icon && board[1] == icon && board[2] == icon) ||
                (board[3] == icon && board[4] == icon && board[5] == icon) ||
                (board[6] == icon && board[7] == icon && board[8] == icon) ||
                (board[0] == icon && board[3] == icon && board[6] == icon) ||
                (board[1] == icon && board[4] == icon && board[7] == icon) ||
                (board[2] == icon && board[5] == icon && board[8] == icon) ||
                (board[0] == icon && board[4] == icon && board[8] == icon) ||
                (board[2] == icon && board[4] == icon && board[6] == icon)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isDraw() {
        for (char space : board) {
            if (space == ' ') {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        initializeBoard();
        for (JButton button : buttons) {
            button.setText("");
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI().setVisible(true);
            }
        });
    }
}
